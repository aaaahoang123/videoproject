package user.login.data;

import user.login.attribute.ResLoginAttribute;

public class ResUserLoginData {
    private String type;
    private String id;
    private ResLoginAttribute attributes;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ResLoginAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(ResLoginAttribute attributes) {
        this.attributes = attributes;
    }
}
