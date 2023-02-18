package exercise;

public class ReversedSequence implements CharSequence {
    private final StringBuilder norm;

    public ReversedSequence(String normal) {
        this.norm = new StringBuilder(normal);
    }

    @Override
    public String toString() {
        return norm.reverse().toString();
    }

    @Override
    public char charAt(int idx) {
        return norm.reverse().toString().charAt(idx);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        String finalNorm = new ReversedSequence(norm.reverse().substring(start, end)).toString();
        return new ReversedSequence(finalNorm);
    }

    @Override
    public int length() {
        return norm.length();
    }
}