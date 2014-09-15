package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static final double pickUPraiseSpeen = .60;
    public static final double pickupLowerSpeed = .40;
    
    
    //auto
    public static final double drivetime = 2.5;
    public static final double drivSpeed = .6;
    public static final double curve = 0;
    
    public static final int Left_Talon = 1,
                            Right_Talon = 2,
                            Loader_Talon = 3,
                            Launcher_Talon = 4,
                            Pickup_Talon_1  = 5,
                            Pickup_Talon_2 = 6;
    
    public static final int Left_Encoder_A = 1,
                            Left_Encoder_B = 2,
                            Right_Encoder_A =3,
                            Right_Encoder_B =4,
                            Pickup_Upper_Stop = 5,
                            Pickup_Lower_Stop = 6,
                            Launcher_Stop = 7,
                            Compressor_Switch = 8,
                            Launcher = 9;
    
    public static final int Shifter_Low = 1,
                            Shifter_High = 2,
                            Blocker_Up = 3,
                            Blocker_Down = 4;
    
    public static final int Compressor_Spike =1,
                            SHIFTER_SPIKE = 2;
    
    public static final int Left_Stick = 1,
                            Right_Stick = 2,
                            Systems_Stick = 3;
    
    
}
