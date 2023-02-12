public class List {
    Object first, current,last;
    int length;

    public List() {
        first = null;
        current = null;
        last = null;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public boolean hasAccess() {
        return current != null;
    }

    public void next() {
        if(this.hasAccess()) {
            current = current.following;
        }
    }
    public void toFirst() {
        if(!isEmpty()) {
            current = first;
        }
    }
    public void toLast() {
        if(!isEmpty()) {
            current = last;
        }
    }
    public Object getObject() {
        if(this.hasAccess()) {
            return current;
        }else {
            return null;
        }
    }
    public void setContent(Object pObject) {
        if(pObject != null && this.hasAccess()) {
            current = pObject;
        }
    }
    public void append(Object pObject) {
        if(pObject != null) {
            if(this.isEmpty()) {
                this.insert(pObject);
            } else {
                last.setFollowing(pObject);
                last = pObject;
            }
        }
    }
    public void insert(Object pObject) {
        if(pObject != null) {
            if(this.hasAccess()) {
                if(current != first) {
                    Object previous = this.getPrevious(current);
                    pObject.setFollowing(previous.getFollowing());
                    previous.setFollowing(pObject);
                } else {
                    pObject.setFollowing(first);
                    first = pObject;
                }
            } else {
                if(this.isEmpty()) {
                    first = pObject;
                    last = pObject;
                }
            }
        }
    }

    public void concat(List pList) {
        if(pList!= this && pList != null && !pList.isEmpty()) {
            if(this.isEmpty()) {
                this.first = pList.first;
                this.last = pList.last;
            } else {
                this.last.setFollowing(pList.first);
                this.last = pList.last;
            }
            pList.first = null;
            pList.current = null;
            pList.last = null;
        }
    }
    public void remove() {
        if(this.hasAccess() && !this.isEmpty()) {
            if(current == first) {
                first = first.getFollowing();
            } else {
                Object previous = this.getPrevious(current);
                if(current == last) {
                    last = previous;
                }
                previous.setFollowing(current.getFollowing());
            }
            Object temp = current.getFollowing();
            current.setName(null);
            current.setFollowing(null);
            current = temp;
        }
    }
    public Object getPrevious(Object pObject) {
        if(pObject != null && pObject != first && !this.isEmpty()) {
            Object temp = first;
            while(temp != null && temp.getFollowing() !=pObject){
                temp = temp.getFollowing();
            }
            return temp;
        } else {
            return null;
        }
    }
}