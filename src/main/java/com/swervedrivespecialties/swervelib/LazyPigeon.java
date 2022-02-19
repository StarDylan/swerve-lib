package com.swervedrivespecialties.swervelib;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.sensors.Pigeon2;

public class LazyPigeon {
    private Pigeon2 lazyPigeon = null;

    private double angle;
    private short[] acceleration;
    private ErrorCode error;

    public void init(int deviceNumber, String canbus) {
        lazyPigeon = new Pigeon2(deviceNumber, canbus);
    }

    public void init(int deviceNumber) {
        lazyPigeon = new Pigeon2(deviceNumber);
    }

    public void periodic() {
        angle = lazyPigeon.getYaw();
        error = lazyPigeon.getBiasedAccelerometer(acceleration);
    }

    public double getYaw() {
        return angle;
    }

    public short[] getBiasedAccelerometer() {
        return acceleration;
    }
}
