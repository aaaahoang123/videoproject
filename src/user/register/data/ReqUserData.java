package user.register.data;

import user.register.attributes.ReqUserAttribute;

public class ReqUserData {
    private String type = "Member";
    private ReqUserAttribute attributes;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ReqUserAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(ReqUserAttribute attributes) {
        this.attributes = attributes;
    }
}
