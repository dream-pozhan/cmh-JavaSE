package cmh.excecise;

import java.util.HashMap;
import java.util.Iterator;

public class MyHashMap<K,V> extends HashMap<K,V> {
    public String toString(){
        Iterator<Entry<K,V>> i = entrySet().iterator();
        if (! i.hasNext())
            return "";

        StringBuilder sb = new StringBuilder();
        for (;;) {
            Entry<K,V> e = i.next();
            K key = e.getKey();
            V value = e.getValue();
            sb.append(key.toString()+"\t");
            sb.append(value.toString()+"\n");
            if (! i.hasNext())
                return sb.toString();
        }
    }
}

