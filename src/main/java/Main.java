import com.adt.datastructure.SerializeDeserialize;

public class Main {

        public static void main(String args[]) throws Exception {
            SerializeDeserialize s= new SerializeDeserialize();
            s.add(1);
            s.add(2);
            s.add(4);
            s.add(6);
            s.add(5);
            s.add(8);
            s.add(9);
            s.add(7);
            s.preOrderAll();
            s.serialize();
            s.deSerialize();
            s.preOrderAll();
        }
}
