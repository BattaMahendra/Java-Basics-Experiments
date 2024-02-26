package collections.generics;

public class Generic<B> {
    public B getaField() {
        return aField;
    }

    public void setaField(B aField) {
        this.aField = aField;
    }

    B aField;
    public <B> B printAndRetrun(B b){
        System.out.println(b);
        return b;
    }

}
