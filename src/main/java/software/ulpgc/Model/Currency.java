package software.ulpgc.Model;

public record Currency(String code) {
    @Override
    public String toString() {
        return code;
    }
}
