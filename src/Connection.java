public class Connection {
    public Connection(String from, String to) {
        throw new UnsupportedOperationException("finish me!");
    }

    public String getFrom() {
        throw new UnsupportedOperationException("finish me!");
    }

    public String getTo() {
        throw new UnsupportedOperationException("finish me too!");
    }

    @Override
    public String toString() {
        return getFrom() + "->" + getTo();
    }

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof Connection)) return false;
        Connection other = (Connection) obj;
        return getFrom().equals(other.getFrom())
            && getTo().equals(other.getTo());
    }

    @Override
    public int hashCode() {
        return getFrom().hashCode() + getTo().hashCode();
    }
}
