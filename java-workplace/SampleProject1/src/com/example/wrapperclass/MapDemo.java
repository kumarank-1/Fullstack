package com.example.wrapperclass;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {
    public static void main(String[] args) {
        // HashMap
        HashMap<Integer, String> map = new HashMap<>();
        map.put(101, "John");
        map.put(334, "Leo");
        map.put(567, "Dave");
        map.put(891, "Anna");
        map.put(902, "George");

        map.put(567, "David"); // update existing key
        map.put(null, "NullKeyAllowed");
        map.put(999, null);

        System.out.println("HashMap is: " + map);

        // LinkedHashMap (insertion order)
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>();
        linkedMap.put(101, "John");
        linkedMap.put(334, "Leo");
        linkedMap.put(567, "Dave");
        linkedMap.put(891, "Anna");
        linkedMap.put(902, "George");

        System.out.println("\nLinkedHashMap is: " + linkedMap);

        // TreeMap (sorted by key, no null key)
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(101, "John");
        treeMap.put(334, "Leo");
        treeMap.put(567, "Dave");
        treeMap.put(891, "Anna");
        treeMap.put(902, "George");

        System.out.println("TreeMap (sorted by keys): " + treeMap);

        // get / contains
        String name = map.get(101);
        System.out.println("\nname is: " + name);
        System.out.println("containsKey(567): " + map.containsKey(567));
        System.out.println("containsValue(\"Dave\"): " + map.containsValue("Dave"));
        System.out.println("containsValue(\"David\"): " + map.containsValue("David"));

        // remove and size
        System.out.println("\nSize before remove: " + map.size());
        map.remove(567);
        System.out.println("Size after remove: " + map.size());

        // keySet iteration
        Set<Integer> keys = map.keySet();
        System.out.println("\nKeys in map are: " + keys);

        Iterator<Integer> itr = keys.iterator();
        System.out.println("Iterate in keys:");
        while (itr.hasNext()) {
            Integer key = itr.next();
            System.out.println(key + " -> " + map.get(key));
        }

        // entrySet iteration
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer, String>> itr1 = entrySet.iterator();

        System.out.println("\nIterate using entrySet:");
        while (itr1.hasNext()) {
            Map.Entry<Integer, String> entry = itr1.next();
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Hashtable (no null key/value)
        Hashtable<Integer, String> table = new Hashtable<>();
        table.put(1, "One");
        table.put(2, "Two");
        // table.put(null, "X"); // Not allowed
        // table.put(3, null);   // Not allowed

        System.out.println("\nHashtable is: " + table);
    }
}
