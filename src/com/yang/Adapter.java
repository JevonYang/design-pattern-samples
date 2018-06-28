package com.yang;

interface USB{
    public void usbInfo();
}

interface TypeC{
    public void typeCInfo();
}

class UsbDevice implements USB{
    @Override
    public void usbInfo() {
        System.out.println("hello, here is a usb device");
    }
}

class ClassAdapter extends UsbDevice implements TypeC{
    @Override
    public void typeCInfo() {
        usbInfo();
    }
}

class ObjectAdapter implements TypeC{

    private USB usb;

    public ObjectAdapter(USB usb) {
        this.usb=usb;
    }

    @Override
    public void typeCInfo() {
        this.usb.usbInfo();
    }
}

interface HDMI{
    public void functionA();
    public void functionB();
    public void functionC();

}

abstract class HDMIAdapter implements HDMI{
    @Override
    public void functionA() {

    }

    @Override
    public void functionB() {

    }

    @Override
    public void functionC() {

    }
}

class HDMIHub extends HDMIAdapter{
    @Override
    public void functionA() {
        System.out.println("Hub use function A;");
    }

    @Override
    public void functionB() {
        System.out.println("Hub use function B;");
    }
}


public class Adapter {
    public static void main(String[] args) {
        ClassAdapter myAdapter = new ClassAdapter();
        myAdapter.typeCInfo();

        ObjectAdapter objectAdapter = new ObjectAdapter(new UsbDevice());
        objectAdapter.typeCInfo();

        HDMIHub hdmiHub = new HDMIHub();
        hdmiHub.functionA();
        hdmiHub.functionB();
    }
}
