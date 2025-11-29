package frc.robot;

import com.ctre.phoenix6.Orchestra;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class Motor {
    public TalonFX mMotor1;
    public TalonFX mMotor2;
    public Orchestra mOrchestra;

    public Motor(){
        this.mMotor1 = new TalonFX(Constants.kMotorID, "rio");
        
        this.mMotor2 = new TalonFX(Constants.k60MotorID, "rio");

        TalonFXConfiguration topFlywheelConfig = new TalonFXConfiguration();
        // Apply configurations
        topFlywheelConfig.CurrentLimits.SupplyCurrentLimitEnable = false;
        topFlywheelConfig.CurrentLimits.SupplyCurrentLimit = Constants.kCurrentLimit;
        topFlywheelConfig.CurrentLimits.StatorCurrentLimitEnable = false;
        topFlywheelConfig.CurrentLimits.StatorCurrentLimit = Constants.kCurrentLimit;
        topFlywheelConfig.Voltage.PeakForwardVoltage = 12;
        topFlywheelConfig.Voltage.PeakReverseVoltage = -12;
        
        topFlywheelConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        topFlywheelConfig.MotorOutput.Inverted = Constants.kInverted
        ? InvertedValue.CounterClockwise_Positive
        : InvertedValue.Clockwise_Positive;

        mMotor1.getConfigurator().apply(topFlywheelConfig);
        
        mMotor2.getConfigurator().apply(topFlywheelConfig);
        mOrchestra = new Orchestra();
        mOrchestra.loadMusic("march.chrp"); 
        mOrchestra.addInstrument(mMotor1);        
        mOrchestra.addInstrument(mMotor2);
        
         
        

    }

    public void ply(){
    
        mOrchestra.play();
        
    }   
}
