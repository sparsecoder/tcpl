public class Connection {
    public Connection(String from, String to) {
        // finish me!
    }

    public String getFrom() {
        return null; // replace me!
    }

    public String getTo() {
        return null; // replace me!
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
