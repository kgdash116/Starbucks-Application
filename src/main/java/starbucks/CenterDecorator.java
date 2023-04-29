package starbucks;


/**
 * Write a description of class CenterDecorator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CenterDecorator extends Decorator

{
    private String text;
    private String screenName;
    private int spaceLength=0;
    private static final int two=2;


    CenterDecorator(IScreen screen)
    {
        super(screen);

    }

    public String display()
    {
        text=super.display();

        return display(text);


    }

     private String padLines(int num) {
        String lines = "" ;
        StringBuffer buff=new StringBuffer();
        for ( int i = 0; i<num; i++ ) {
            System.err.print(".") ;
            buff.append("\n") ;
        }
        System.err.println("") ;
        lines=buff.toString(); 
        return lines ;
    }

    private int countLines(String str){


        int lines=0;
        String[] arrOfStr = str.split("\n");
        lines=arrOfStr.length;

        return lines ;
    }

    private String padSpaces(int num) {
        String spaces = "" ;

        StringBuffer buff=new StringBuffer();


        for ( int i = 0; i<num; i++ )
            {buff.append(" ");}
        spaces=buff.toString();
        return spaces ;
    }


    public String name()
    {
        screenName=super.name();
        return centeredName(screenName);

    }

    public String centeredName(String arr)
    {

        Device d=Device.getInstance();
        int w=0;
        int padding;
        String out="";
        Device.ORIENTATION_MODE m= d.getDeviceOrientation();
        switch(m)
        {
        case PORTRAIT:
        w=Device.portrait_screen_width;
        break;
        case LANDSCAPE:
        w=Device.landscape_screen_width;
        break;
        }
        if (arr.length()%two==0)
            {
                padding=((w-arr.length())/two)+1;
                out+=padSpaces(padding)+arr;



            }

            else
            {
                padding=((w-arr.length())/two);
                out+=padSpaces(padding)+arr;



            }

    return out;
    }

    public String display(String arr)

    {
        int length=0;
        int width=0;
        int height=0;
        Device d=Device.getInstance();
        Device.ORIENTATION_MODE m= d.getDeviceOrientation();
        switch(m)
        {
        case PORTRAIT:
        height=Device.screen_frame_header;
        width=Device.portrait_screen_width;
        length=Device.portrait_screen_length;
        break;
        case LANDSCAPE:
        height=Device.screen_frame_header;
        width=Device.landscape_screen_width;
        length=Device.landscape_screen_length;
        break;
        }
        String output="";
        //String paste="";
        String[] displayText = arr.split("\n");
        int cnt1=countLines(arr);
        StringBuffer buff = new StringBuffer();
        //output+=padLines((length-cnt1)/two);
        buff.append(padLines((length-cnt1)/two));
        int cnt2;
        int pad2;

        for (String a : displayText)
        {
            if (a.length()%two==0)
            {
                spaceLength=((width-a.length())/two)+1;
                //output+=padSpaces(spaceLength)+a+"\n";
                buff.append(padSpaces(spaceLength)+a+"\n");


            }

            else
            {
                spaceLength=((width-a.length())/two);
                //output+=padSpaces(spaceLength)+a+"\n";
                buff.append(padSpaces(spaceLength)+a+"\n");


            }
        }

        //output=padLines((length-cnt1)/2)+output;
        //paste=buff.toString();
        cnt2=countLines(buff.toString());
        pad2=length-cnt2;
        System.err.println("cnt2: "+cnt2);
        System.err.println("pad2: "+pad2);
      //  output+=padLines(pad2);
        buff.append(padLines(pad2));
        output+=buff.toString();
        return output;



    }
}
