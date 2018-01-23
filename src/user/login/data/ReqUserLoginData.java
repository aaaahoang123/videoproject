package user.login.data;

import user.login.attribute.ReqLoginAttribute;

public class ReqUserLoginData {
    private final String type = "MemberLogin";
    private ReqLoginAttribute attributes;

    public String getType() {
        return type;
    }

    public ReqLoginAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(ReqLoginAttribute attributes) {
        this.attributes = attributes;
    }
}
