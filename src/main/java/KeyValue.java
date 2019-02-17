
public class KeyValue<K, V> {

    public K key;
    public V value;


    public KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKeyOfkv() {
        return key;
    }

    public void setKeyOffkv(K key) {
        this.key = key;
    }

    public V getValueOfkv() {
        return value;
    }

    public void setValueOffkv(V value) {
        this.value = value;
    }
}
