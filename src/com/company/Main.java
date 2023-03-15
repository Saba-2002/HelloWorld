package com.company;

/*


1. გვაქვს მთელი რიცხვების ჩამონათვალი სადაც  ერთის გარდა ყველა რიცხვი  მეორდება, იპოვეთ ის რიცხვი რომელიც არ მეორდება.int singleNumber(int[] nums)

2. გვაქვს 1,5,10,20 და 50 თეთრიანი მონეტები. დაწერეთ ფუნქცია, რომელსაც გადაეცემა თანხა (თეთრებში) და აბრუნებს მონეტების მინიმალურ რაოდენობას,
რომლითაც შეგვიძლია ეს თანხა დავახურდაოთ.
Int minSplit(Int amount);

3. მოცემულია მასივი, რომელიც შედგება მთელი რიცხვებისგან. დაწერეთ ფუნქცია რომელსაც გადაეცემა ეს მასივი და აბრუნებს მინიმალურ მთელ რიცხვს,
რომელიც 0-ზე მეტია და ამ მასივში არ შედის.
Int notContains(Int[] array);

4.მოცემულია ორი binary string a და b, დააბრუნეთ მათი ჯამი, როგორც binary string.
მაგ: a = "1010" b = "1011" , მათი ჯამი იქნება "10101"

5. გვაქვს n სართულიანი კიბე, ერთ მოქმედებაში შეგვიძლია ავიდეთ 1 ან 2 საფეხურით. დაწერეთ ფუნქცია რომელიც დაითვლის n სართულზე ასვლის
ვარიანტების რაოდენობას.
Int countVariants(Int stearsCount);

6. დაწერეთ საკუთარი მონაცემთა სტრუქტურა, რომელიც საშუალებას მოგვცემს O(1) დროში წავშალოთ ელემენტი.

 */

public class Main {

    public static String binaryadd(String b1, String b2){
        boolean leastSignificantBit1;
        boolean leastSignificantBit2;
        boolean mem = false;
        int lastindex1 = b1.length();
        int lastindex2 = b2.length();
        String ans = new String();
        while (lastindex1 >= 0 && lastindex2 >= 0){
            if(lastindex1 < 1){
                leastSignificantBit1 = false;
            }
            else{
                leastSignificantBit1 = (b1.charAt(lastindex1 - 1) == '1') ? true : false;
            }
            if (lastindex2 < 1){
                leastSignificantBit2 = false;
            }
            else {
                leastSignificantBit2 = (b2.charAt(lastindex2 - 1) == '1') ? true : false;

            }
            if(lastindex1 == lastindex2){
                ans += mem ? "1" : "0";
            }
            else {
                ans += mem ? "0" : "1";
            }
            mem = leastSignificantBit1 == true && leastSignificantBit2 == true ? true : false;
            lastindex2--;
            lastindex1--;
        }

        ans += mem ? "1" : "0";

        return ans;
    }

    public static int countVariants(int stearsCount) {
        int n = stearsCount;
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(arr[n - 1]);
        return arr[n - 1];
    }



    public static int singleNumber(int[] nums) {
        int n = nums.length;
        int res = nums[0];

        for (int i = 1; i < n; i++) {
            res ^= nums[i];
        }


        return res;
    }


    public static int minSplit(int amount) {
        int res = 0;
        int[] arr = new int[]{1,2,5,10,20,50};

        for (int i = arr.length-1; i > 0; i--) {
            int temp = amount / arr[i];
            int rest = amount - (temp * arr[i]);
            amount = amount - (temp * arr[i]);
            res += temp;

        }

        return res;

    }

    public static int notContains(int[] array){
        int min = Integer.MAX_VALUE;
        int res = 0;

        for(Integer i : array) {
            if (i < min && i > 0) {
                min = i;
            }
        }

        for (int i = 0; i < min; i++) {
            if (i < min) {
                res = 1;
                break;
            }
        }
        return res;
    }


    //





//    HashMapEntry(int h, K k, V v, HashMapEntry<K,V> n) {
//        value = v;
//        key = k;
//        hash = h;
//        next = n; // new Node i.e. Node3 is created with its next pointing to n which is Node1 passed.
//    }
//    public V put(K key, V value) {
//        if (table == EMPTY_TABLE) {
//            inflateTable(threshold);
//        }
//        if (key == null)
//            return putForNullKey(value);
//        int hash = sun.misc.Hashing.singleWordWangJenkinsHash(key);
//        int i = indexFor(hash, table.length);
//        for (HashMapEntry<K,V> e = table[i]; e != null; e = e.next) {
//            Object k;
//            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
//                V oldValue = e.value;
//                e.value = value;
//                e.recordAccess(this);
//                return oldValue;
//            }
//     }
//
//        modCount++;
//        addEntry(hash, key, value, i);
//        return null;
//}
//
//    public V get(Object key) {
//        if (key == null)
//            return getForNullKey();
//        Entry<K,V> entry = getEntry(key);
//
//        return null == entry ? null : entry.getValue();
//    }

    public static void main(String[] args) {
//        System.out.println(minSplit(35));
//        System.out.println(notContains (new int[]{-4,-40,20,3,120}));
//        System.out.println(singleNumber(new int[]{2,3,7,3,6,2}));
//        System.out.println(countVariants(10));
        System.out.print(binaryadd("1010", "1011"));
    }
}

