package testCode;

import static testCode.MyItem.MAX_SIZE;

/**
 * Created by xiaokai on 2017/2/8.
 */
class MyItem {
    static final int MAX_SIZE = 1000;
    byte type;
    byte color;
    byte price;

    MyItem(byte type, byte color, byte price) {
        this.type = type;
        this.color = color;
        this.price = price;
    }
}

class ByteStore {
    byte[] storeByteArray;

    public static void main(String[] args) {
        MyItem myItem = new MyItem((byte) 1, (byte) 1, (byte) 1);
        ByteStore byteStore = new ByteStore();
        byteStore.putMyitem(0, myItem);
        System.out.println(byteStore.getMyItem(0).equals(myItem));
    }

    void putMyitem(int index, MyItem item) {
        if (item == null) {
            throw new IllegalArgumentException("item 为空");
        }
        if (index >= MAX_SIZE && index < 0) {
            throw new IllegalArgumentException("超过边界");
        }
        if (storeByteArray == null) {
            storeByteArray = new byte[MAX_SIZE * 3];
        }
        storeByteArray[3 * index] = item.type;
        storeByteArray[3 * index + 1] = item.color;
        storeByteArray[3 * index + 2] = item.price;
    }

    MyItem getMyItem(int index) {
        return new MyItem(storeByteArray[index], storeByteArray[index + 1], storeByteArray[index + 2]);
    }
}


