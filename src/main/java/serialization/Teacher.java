package serialization;

import lombok.ToString;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/*
*
* Externalization is an alternative to serialization where developer have full control over
* serialization and deserialization
*
* ** Unlike Serializable interface externalizable is not a marker interface. Rather it contains two abstract methods
*    1. writeExternal(ObjectOutput )
*    2. readExternal(ObjectInput)
*
* Externalizable internally extends Serializable interface
* */

@ToString
public class Teacher implements Externalizable {

    String name;
    String dept;

    public Teacher(){
        System.out.println("No args constructor is being called");
    }

    public Teacher(String name, String dept) {
        this.name = name;
        this.dept = dept;
    }


    /**
     * Must be overridden methods
    * */

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        //custome defining what to serialize
        out.writeObject(this.name);
        out.writeObject(this.dept);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        //custome defining what to deserialize
        this.name = (String) in.readObject();
        this.dept = (String) in.readObject();

    }
}
