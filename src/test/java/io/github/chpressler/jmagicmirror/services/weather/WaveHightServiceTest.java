package io.github.chpressler.jmagicmirror.services.weather;

import junit.framework.TestCase;

public class WaveHightServiceTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testGetWaveHeight() throws Exception {

        WaveHightService service = new WaveHightService();

        System.out.println("getWaveHeight: " + service.getWaveHeight());
    }

    public void testGetForcast() throws Exception {
    }

    public void testGetAlert() throws Exception {
    }

}