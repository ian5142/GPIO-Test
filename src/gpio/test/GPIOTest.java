package gpio.test;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import digits.*;
import java.util.ArrayList;

/**
 * Tests for Two 7-Segment displays attached to a Raspberry PI.
 * @author Ian Van Schaick
 */
public class GPIOTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("<--Pi4J--> GPIO Control Example ... started.");
        
        Digits displayDigits = new Digits();
        
        // create gpio controller
//        final GpioController gpio = GpioFactory.getInstance();
        
        ArrayList<GpioPinDigitalOutput> digitPins = new ArrayList<GpioPinDigitalOutput> ();
        ArrayList<GpioPinDigitalOutput> digitPins2 = new ArrayList<GpioPinDigitalOutput> ();
        
//        for (int i = 0 ; i <= 8 ; i++) {
            final GpioController gpio = GpioFactory.getInstance();
            digitPins = displayDigits.getDigitPins(0, 6);
            digitPins2 = displayDigits.getDigitPins(1, 6);
            for (int j = 0 ; j < digitPins.size() && j < digitPins2.size() ; j++) {
                final GpioPinDigitalOutput pinI = digitPins.get(j);
                pinI.setShutdownOptions(true, PinState.LOW);
                pinI.toggle();
                
                final GpioPinDigitalOutput pinI2 = digitPins2.get(j);
                pinI2.setShutdownOptions(true, PinState.LOW);
                pinI2.toggle();
                Thread.sleep(200);
            }
            Thread.sleep(10000);
            gpio.shutdown();
//        }
        

        /**
         * Uncomment following lines to display rotating segment on each display.
         */
        // provision gpio pin #01 as an output pin and turn on
//        final GpioPinDigitalOutput pin00 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "Segment A", PinState.HIGH);
//        final GpioPinDigitalOutput pin01 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "Segment B", PinState.HIGH);
//        final GpioPinDigitalOutput pin02 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "Segment C", PinState.HIGH);
//        final GpioPinDigitalOutput pin03 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "Segment D", PinState.HIGH);
//        final GpioPinDigitalOutput pin04 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "Segment E", PinState.HIGH);
//        final GpioPinDigitalOutput pin05 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "Segment F", PinState.HIGH);
//        final GpioPinDigitalOutput pin06 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "Segment G", PinState.HIGH);
//        final GpioPinDigitalOutput pin07 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, "Segment DP", PinState.HIGH);
//        
//        final GpioPinDigitalOutput pin08 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, "Segment A1", PinState.HIGH);
//        final GpioPinDigitalOutput pin09 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09, "Segment B1", PinState.HIGH);
//        final GpioPinDigitalOutput pin10 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_10, "Segment C1", PinState.HIGH);
//        final GpioPinDigitalOutput pin11 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_11, "Segment D1", PinState.HIGH);
//        final GpioPinDigitalOutput pin12 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12, "Segment E1", PinState.HIGH);
//        final GpioPinDigitalOutput pin13 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13, "Segment F1", PinState.HIGH);
//        final GpioPinDigitalOutput pin14 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_14, "Segment G1", PinState.HIGH);
//        final GpioPinDigitalOutput pin15 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15, "Segment DP1", PinState.HIGH);
//        
//        // set shutdown state for this pin
//        pin00.setShutdownOptions(true, PinState.LOW);
//        pin01.setShutdownOptions(true, PinState.LOW);
//        pin02.setShutdownOptions(true, PinState.LOW);
//        pin03.setShutdownOptions(true, PinState.LOW);
//        pin04.setShutdownOptions(true, PinState.LOW);
//        pin05.setShutdownOptions(true, PinState.LOW);
//        pin06.setShutdownOptions(true, PinState.LOW);
//        pin07.setShutdownOptions(true, PinState.LOW);
//        
//        pin08.setShutdownOptions(true, PinState.LOW);
//        pin09.setShutdownOptions(true, PinState.LOW);
//        pin10.setShutdownOptions(true, PinState.LOW);
//        pin11.setShutdownOptions(true, PinState.LOW);
//        pin12.setShutdownOptions(true, PinState.LOW);
//        pin13.setShutdownOptions(true, PinState.LOW);
//        pin14.setShutdownOptions(true, PinState.LOW);
//        pin15.setShutdownOptions(true, PinState.LOW);
//        
//        ArrayList<GpioPinDigitalOutput> pins = new ArrayList<GpioPinDigitalOutput> ();
//        pins.add(pin00);
//        pins.add(pin01);
//        pins.add(pin02);
//        pins.add(pin03);
//        pins.add(pin04);
//        pins.add(pin05);
//        pins.add(pin06);
//        pins.add(pin07);
//        
//        pins.add(pin08);
//        pins.add(pin09);
//        pins.add(pin10);
//        pins.add(pin11);
//        pins.add(pin12);
//        pins.add(pin13);
//        pins.add(pin14);
//        pins.add(pin15);
//        for (int j = 0; j < 1000; j++) {
//            for (int i = 0; i < pins.size(); i++) {
//                System.out.println("pin:" + i + " --> " + pins.get(i).getName() + " : ON");
//                final GpioPinDigitalOutput pinI = pins.get(i);
//                pinI.setShutdownOptions(true, PinState.LOW);
//
//                pinI.pulse(100, true);
//
//                System.out.println("pin:" + i + " --> " + pins.get(i).getName() + " GPIO state should be: OFF");
//                Thread.sleep(100);
//            }
//        }



//        // toggle the current state of gpio pin #01 (should turn on)
//        pin01.toggle();
//        System.out.println("--> GPIO state should be: ON");
//
//        Thread.sleep(1000);
//
//        // toggle the current state of gpio pin #01  (should turn off)
//        pin01.toggle();
//        System.out.println("--> GPIO state should be: OFF");
//
//        Thread.sleep(1000);
//
//        // turn on gpio pin #01 for 1 second and then off
//        System.out.println("--> GPIO state should be: ON for only 1 second");
//        pin01.pulse(1000, true); // set second argument to 'true' use a blocking call

        // stop all GPIO activity/threads by shutting down the GPIO controller
        // (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)
//        gpio.shutdown();

        System.out.println("Exiting ControlGpioExample");
    }
    
}
