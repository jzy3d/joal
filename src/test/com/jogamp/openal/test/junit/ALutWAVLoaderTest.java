package com.jogamp.openal.test.junit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.junit.Test;
import org.junit.Assert;

import com.jogamp.openal.test.resources.ResourceLocation;
import com.jogamp.openal.util.ALut;
import com.jogamp.openal.util.WAVData;
import com.jogamp.openal.util.WAVLoader;

public class ALutWAVLoaderTest {

    @Test
    public void testALutLoadWAVFileStream() throws IOException {
        // variables to load into
        int[] format = new int[1];
        int[] size = new int[1];
        ByteBuffer[] data = new ByteBuffer[1];
        int[] freq = new int[1];
        int[] loop = new int[1];

        ALut.alutLoadWAVFile(ResourceLocation.getTestStream0(), format, data, size, freq, loop);
        System.out.println("*** ALut.alutLoadWAV Stream0 size "+size[0]);
        Assert.assertTrue("Stream0 size "+ResourceLocation.getTestStream0Size()+" < "+size[0], size[0] <= ResourceLocation.getTestStream0Size());

        ALut.alutLoadWAVFile(ResourceLocation.getTestStream3(), format, data, size, freq, loop);
        System.out.println("*** ALut.alutLoadWAV Stream3 size "+size[0]);
        Assert.assertTrue("Stream3 size "+ResourceLocation.getTestStream3Size()+" < "+size[0], size[0] <= ResourceLocation.getTestStream3Size());

    }

    @Test
    public void testWAVDataLoadStream() throws IOException {
    	WAVData wd0 = WAVData.loadFromStream(ResourceLocation.getTestStream0(), ResourceLocation.getTestStream0Size(), 1, 8, 22050, ByteOrder.LITTLE_ENDIAN, true);
    	System.out.println("*** WAVData.loadFrom Stream0 size "+wd0.data.limit());
    	assertEquals(wd0.data.limit(), ResourceLocation.getTestStream0Size());

        WAVData wd1 = WAVData.loadFromStream(ResourceLocation.getTestStream1(), ResourceLocation.getTestStream1Size(), 2, 16, 44100, ByteOrder.BIG_ENDIAN, true);
        System.out.println("*** WAVData.loadFrom Stream1 size "+wd1.data.limit());
        assertEquals(wd1.data.limit(), ResourceLocation.getTestStream1Size());

        WAVData wd2 = WAVData.loadFromStream(ResourceLocation.getTestStream2(), ResourceLocation.getTestStream2Size(), 2, 16, 44100, ByteOrder.LITTLE_ENDIAN, true);
        System.out.println("*** WAVData.loadFrom Stream2 size "+wd2.data.limit());
        assertEquals(wd2.data.limit(), ResourceLocation.getTestStream2Size());

        WAVData wd3 = WAVData.loadFromStream(ResourceLocation.getTestStream3(), ResourceLocation.getTestStream3Size(), 2, 16, 44100, ByteOrder.LITTLE_ENDIAN, true);
        System.out.println("*** WAVData.loadFrom Stream3 size "+wd3.data.limit());
        assertEquals(wd3.data.limit(), ResourceLocation.getTestStream3Size());

    }

    @Test
    public void testWAVLoaderLoadStream() throws IOException {
    	WAVData wd0 = WAVLoader.loadFromStream(ResourceLocation.getTestStream0());
    	System.out.println("*** WAVLoader.loadFrom Stream0 size "+wd0.data.limit());
        Assert.assertTrue("Stream0 size "+ResourceLocation.getTestStream0Size()+" < "+wd0.data.limit(), wd0.data.limit() <= ResourceLocation.getTestStream0Size());

        WAVData wd3 = WAVLoader.loadFromStream(ResourceLocation.getTestStream3());
        System.out.println("*** WAVLoader.loadFrom Stream3 size "+wd3.data.limit());
        Assert.assertTrue("Stream3 size "+ResourceLocation.getTestStream3Size()+" < "+wd3.data.limit()+" .. "+wd3.data, wd3.data.limit() <= ResourceLocation.getTestStream3Size());
    }

    // TODO test * LoadFile

    public static void main(String args[]) throws IOException {
        org.junit.runner.JUnitCore.main(ALutWAVLoaderTest.class.getName());
    }
}