public class Friend {
    String name;
    String phone;
    String email;

    public Friend(String name, String phone, String email) {
        this.name = name.trim();
        this.phone = phone.trim();
        this.email = email.trim();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return name + " " + phone + " " + email;
    }
   /* public boolean equals(Object o) {
        Friend other = (Friend) o;
        boolean isEqual;
        if (this.getName() == ot)
    }
*/

    public boolean equals(Object o) {
        Friend other = (Friend) o;
        return this.getName().equalsIgnoreCase(other.getName())
                && this.getPhone().equals(other.getPhone())
                && this.getEmail().equalsIgnoreCase(other.getEmail());
    }

}