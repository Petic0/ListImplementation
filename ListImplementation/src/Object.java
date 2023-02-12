public class Object {
    String name;
    Object following;
    public Object(String pName) {
        if(pName!= null) {
            this.name = pName;
            this.following = null;
        }
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setFollowing(Object following) {
        this.following = following;
    }
    public Object getFollowing() {
        return this.following;
    }
}
