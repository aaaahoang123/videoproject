package user.register.data;

import user.register.attributes.ResUserAttribute;

public class ResUserData {
    private String type;
    private String id;
    private ResUserAttribute attributes;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ResUserAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(ResUserAttribute attributes) {
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
