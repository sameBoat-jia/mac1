package cn.edu.tjut.stud.common;

public record R(int code, Object data, String message) {

    public static R success(Object data) {
        return new R(200, data, null);
    }

    public static R error(int code, String message) {
        return new R(code, null, message);
    }
}
