import org.apache.commons.collections15.Transformer;

public class UnicodeVertexStringer<V> implements Transformer<V,String> {
    @Override
    public String transform(V input) { return input.toString(); }
}
