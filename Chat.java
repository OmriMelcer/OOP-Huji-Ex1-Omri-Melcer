import java.util.Scanner;
class Chat
{
    public static void main(String[] args){
        ChatterBot[] bots = new ChatterBot[2];
        Scanner scanner = new Scanner(System.in);
        String[] illegalReplies1, illegalReplies2,legalReplies1, legalReplies2;
        String legal_pattern1 = "I must say: " + ChatterBot.LIGAL_REQUEST_PATTERN + " because you said say..";
        String legal_pattern2 = "say " + ChatterBot.LIGAL_REQUEST_PATTERN + "? OK.. " + ChatterBot.LIGAL_REQUEST_PATTERN;
        String legal_pattern3 = "if you say say, I will obey and say " + ChatterBot.LIGAL_REQUEST_PATTERN;
        String legal_pattern4 = ChatterBot.LIGAL_REQUEST_PATTERN + " I must say, because you said say";
        String illigalReply1 = "what";
        String illigalReply2 = "no say no way, I won't say " + ChatterBot.ILLIGAL_REQUEST_PATTERN;
        String illigalReply3 = "whaaat";
        String illigalReply4 = "say what?" + ChatterBot.ILLIGAL_REQUEST_PATTERN + "? what's that " +
                ChatterBot.ILLIGAL_REQUEST_PATTERN + "?";
        illegalReplies1 = new String[]{illigalReply1, illigalReply2};
        illegalReplies2 = new String[]{illigalReply3, illigalReply4};
        legalReplies1 = new String[]{legal_pattern1, legal_pattern2};
        legalReplies2 = new String[]{legal_pattern3, legal_pattern4};
        bots[0] = new ChatterBot("shoken",legalReplies1, illegalReplies1);
        bots[1] = new ChatterBot("nissan",legalReplies2, illegalReplies2);
        String stat = "say hello";
        System.out.println(stat);
        int currentBot = 0;
        String curName;
        while (true)
        {
            stat = bots[currentBot].replyTo(stat);
            curName = bots[currentBot].getName();
            System.out.print(curName + ": " + stat);
            currentBot = 1 - currentBot;
            scanner.nextLine();
        }
    }
}