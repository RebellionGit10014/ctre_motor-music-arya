package frc.robot;

import com.ctre.phoenix6.Orchestra;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class Motor {
    public TalonFX mBackLeft;
    public TalonFX mBackRight;
    public TalonFX mFrontLeft;
    public TalonFX mFrontRight;
    public TalonFX mABL;
    public TalonFX mABR;
    public TalonFX mAFL;
    public TalonFX mAFR;

    public Orchestra mOrchestra1;
    public Orchestra mOrchestra2;
    public Orchestra mOrchestra3;
    public Orchestra mOrchestra4;


    public Motor(){
        this.mBackLeft = new TalonFX(Constants.kBackLeftMotorID, "rebeldrive");
        this.mBackRight = new TalonFX(Constants.kBackRightMotorID, "rebeldrive");
        this.mFrontLeft = new TalonFX(Constants.kFrontLeftMotorID, "rebeldrive");
        this.mFrontRight = new TalonFX(Constants.kFrontRightMotorID, "rebeldrive");
        this.mABL = new TalonFX(Constants.kAzimuthBackLeftMotorID, "rebeldrive");
        this.mABR = new TalonFX(Constants.kAzimuthBackRightMotorID, "rebeldrive");
        this.mAFL = new TalonFX(Constants.kAzimuthFrontLeftMotorID, "rebeldrive");
        this.mAFR = new TalonFX(Constants.kAzimuthFrontRightMotorID, "rebeldrive");
        TalonFXConfiguration motorConfig = new TalonFXConfiguration();
        // Apply configurations
        motorConfig.CurrentLimits.SupplyCurrentLimitEnable = false;
        motorConfig.CurrentLimits.SupplyCurrentLimit = Constants.kCurrentLimit;
        motorConfig.CurrentLimits.StatorCurrentLimitEnable = false;
        motorConfig.CurrentLimits.StatorCurrentLimit = Constants.kCurrentLimit;
        motorConfig.Voltage.PeakForwardVoltage = 12;
        motorConfig.Voltage.PeakReverseVoltage = -12;
        
        motorConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        motorConfig.MotorOutput.Inverted = Constants.kInverted
        ? InvertedValue.CounterClockwise_Positive
        : InvertedValue.Clockwise_Positive;

        mFrontLeft.getConfigurator().apply(motorConfig);
        mFrontRight.getConfigurator().apply(motorConfig);
        mBackLeft.getConfigurator().apply(motorConfig);
        mBackRight.getConfigurator().apply(motorConfig);
        mABR.getConfigurator().apply(motorConfig);
        mABL.getConfigurator().apply(motorConfig);
        mAFR.getConfigurator().apply(motorConfig);
        mAFL.getConfigurator().apply(motorConfig);


        
        mOrchestra1 = new Orchestra();
        mOrchestra1.loadMusic("mario.chrp"); 
        mOrchestra1.addInstrument(mFrontLeft);        
        mOrchestra1.addInstrument(mFrontRight);

        mOrchestra2 = new Orchestra();
        mOrchestra2.loadMusic("mario.chrp");
        mOrchestra2.addInstrument(mBackLeft);
        mOrchestra2.addInstrument(mBackRight);

        mOrchestra3 = new Orchestra();
        mOrchestra3.loadMusic("mario.chrp");
        mOrchestra3.addInstrument(mABR);        
        mOrchestra3.addInstrument(mABL);

        mOrchestra4 = new Orchestra();
        mOrchestra4.loadMusic("mario.chrp");
        mOrchestra4.addInstrument(mAFR);
        mOrchestra4.addInstrument(mAFL);
        
    }

    public void ply(){
    
        mOrchestra1.play();
        mOrchestra2.play();
        mOrchestra3.play();
        mOrchestra4.play();
    }   
}