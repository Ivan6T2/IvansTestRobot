package frc.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import com.kauailabs.navx.frc.AHRS;
//import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.SPI;
//import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SerialPort;
//import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.IterativeRobot;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
enum AutonMotions
{
    MOVE1,
    MOVE2,
    MOVE3,
    MOVE4,
    MOVE5,
    DONE
}
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
      private final DifferentialDrive m_robotDrive
      = new DifferentialDrive(new Spark(0), new Spark(1));
      private final Joystick m_stick = new Joystick(0);
      private final Timer m_timer = new Timer();

      private static final int kEncoderPortA = 0;
      private static final int kEncoderPortB = 1;

      
      private SpeedController m_motor;
      private Joystick m_joystick;
      private Encoder m_encoder;
      private boolean isAtTarget = false;
      //private SendableChooser<String> m_chooser = new SendableChooser<>();

        Joystick stick;
        AHRS ahrs;
        AutonMotions m_autonState;
       
        

// This function is run when the robot is first started up and should be
        // used for any initialization code.      
  
  @Override
        public void robotInit() {
          
          ahrs = new AHRS(SerialPort.Port.kUSB);
          m_encoder = new Encoder(kEncoderPortA, kEncoderPortB);

         // m_chooser.addDefault("Default Auto", kDefaultAuto);
             // m_chooser.addObject("My Auto", kCustomAuto);
         //SmartDashboard.putData("Auto modes", m_chooser);
         //<blockquote><pre>{@code
        // Timer timer = new Timer();
    }
        

 
        /*
   * The RobotPeriodic function is called every control packet no matter the
   * robot mode.
   */
  @Override
  public void robotPeriodic() {
    //ahrs.zeroYaw();
         SmartDashboard.putNumber("Encoder", m_encoder.getDistance());
  
        //SmartDashboard.putBoolean(  "IMU_IsCalibrating",    ahrs.isCalibrating());
        SmartDashboard.putNumber(   "IMU_Yaw",              ahrs.getYaw());
        //SmartDashboard.putNumber(   "IMU_Pitch",            ahrs.getPitch());
        //SmartDashboard.putNumber(   "IMU_Roll",             ahrs.getRoll());
        }
        

  
   /* This function is run once each time the robot enters autonomous mode.
   */


    @Override
  public void autonomousInit() {
    m_robotDrive.setSafetyEnabled(false);
    m_encoder.reset();
   //     AutonMotions MOVE1;
        m_autonState = AutonMotions.MOVE1; // first state
    m_robotDrive.arcadeDrive(0.5, 0.0);   // get it started
  }

    // This function is called periodically during autonomous
    @Override
    public void autonomousPeriodic() {
     
      SmartDashboard.putNumber("Encoder", m_encoder.getDistance());
      SmartDashboard.putNumber("IMU_Yaw",ahrs.getYaw());

     switch(m_autonState)
    {
        case junkkMOVE1:
        break;
        case MOVE2:
        break;
        case MOVE3:
        break;
        case MOVE4:
        break;
        case MOVE5:
        break;
        case DONE:
        break;
    } 
             }
           
 


/**
   * This function is called once each time the robot enters teleoperated mode.
   */

  @Override
  public void teleopInit() {
  }
        
           // Stop robot
                //m_robotDrive.arcadeDrive(0.0, 0.0);
                //break;
        
    
    
    
    @Override
    public void teleopPeriodic() {
        m_robotDrive.setSafetyEnabled(true);
        while (isOperatorControl() && isEnabled()) {
            // Drive arcade style
            m_robotDrive.arcadeDrive(-m_stick.getY(), m_stick.getX());
            SmartDashboard.putNumber("Encoder", m_encoder.getDistance());
            SmartDashboard.putNumber( "IMU_Yaw", ahrs.getYaw());
            // The motors will be updated every 5ms
            Timer.delay(0.005);
    }}

  


   /* This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }}
