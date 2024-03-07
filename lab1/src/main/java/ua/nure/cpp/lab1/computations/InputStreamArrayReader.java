package ua.nure.cpp.lab1.computations;

import lombok.AllArgsConstructor;

import java.io.InputStream;

@AllArgsConstructor
public abstract class InputStreamArrayReader implements ArrayReader {
    protected InputStream inputStream;
}
