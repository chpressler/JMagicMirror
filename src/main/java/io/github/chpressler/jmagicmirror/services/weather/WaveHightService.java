package io.github.chpressler.jmagicmirror.services.weather;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.net.URL;

public class WaveHightService {

    public String getWaveHeight() {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream input = new URL("http://forecast.weather.gov/shmrn.php?mz=lmz741").openStream();
            int i;
            while ((i = input.read()) > -1) {
                sb.append((char) i);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        String[] sa = sb.toString().split("\\.");
        for(String s : sa) {
            if(s.contains(" ft ")) {
                return s;
            }
        }
        return null;
    }

    public String getForcast() {
return null;
    }

    public String getAlert() {
return null;
    }

    private String parseAsXML() {
        try {
            InputStream input = new URL("http://forecast.weather.gov/shmrn.php?mz=lmz741").openStream();

            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(input);
            String tagContent = null;
            while(reader.hasNext()){
                int event = reader.next();

                switch(event){
                    case XMLStreamConstants.START_ELEMENT:
                        if ("div".equals(reader.getLocalName())){
                            System.out.println(reader.getAttributeValue(0));
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        tagContent = reader.getText().trim();
                        System.out.println("Content: " + tagContent);
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        switch(reader.getLocalName()){
                            case "div":
                                //empList.add(currEmp);
                                break;
                        }
                        break;

                    case XMLStreamConstants.START_DOCUMENT:
                        //empList = new ArrayList<>();
                        break;
                }

            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
