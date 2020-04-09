package cn.zjut.hotel.config;

/**
 * @author kuluo
 */

public enum RoleToken {
    // 教师令牌
    WAITER("waiter-token"),
    // 管理员令牌
    ADMIN("admin-token");

    private final String tokenName;

    RoleToken(String tokenName) {
        this.tokenName = tokenName;
    }

    public String getTokenName() {
        return tokenName;
    }
}
