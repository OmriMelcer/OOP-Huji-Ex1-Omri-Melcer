import java.util.*;

/**
 * Base file for the ChatterBot exercise.
 * The bot's replyTo method receives a statement.
 * If it starts with the constant REQUEST_PREFIX, the bot returns
 * whatever is after this prefix. Otherwise, it returns one of
 * a few possible replies as supplied to it via its constructor.
 * In this case, it may also include the statement after
 * the selected reply (coin toss).
 * @author Dan Nirel
 */

/** TODO: make a pattern as a static constant for <phrase>
 * TODO: make reply to legal function that will come out of reply to
 * TODO: Make a pattern as a static constant for <request>\
 *
 */
class ChatterBot {
	static final String REQUEST_PREFIX = "say ";
    static final String REQUEST_echo = "echo ";
    static final String LIGAL_REQUEST_PATTERN = "<phrase>";
    static final String ILLIGAL_REQUEST_PATTERN = "<request>";
	private String name;

	Random rand = new Random();
	String[] illegalRequestsReplies;
    String[] legalRequestsReplies;

	public ChatterBot(String name,String[] legalRequestsReplies, String[] illegalRequestsReplies) {
		this.illegalRequestsReplies = new String[illegalRequestsReplies.length];
		this.legalRequestsReplies = new String[legalRequestsReplies.length];
        copy_str_array(illegalRequestsReplies, this.illegalRequestsReplies);
        copy_str_array(legalRequestsReplies, this.legalRequestsReplies);
        this.name = name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String replyTo(String statement) {
		if(statement.startsWith(REQUEST_PREFIX) || statement.startsWith(REQUEST_echo)) {
			//we don’t repeat the request prefix, so delete it from the reply
			return replyToLegalRequest(statement);
		}
		return replyToIllegalRequest(statement);
	}     
    private String replyToLegalRequest(String statement) {
        if (statement.startsWith(REQUEST_echo)) {
            return statement.replaceFirst(REQUEST_echo, "");
        }
        return replaceAPlaceholderInARandomPattern
                (legalRequestsReplies, LIGAL_REQUEST_PATTERN,
                        statement.replaceFirst(REQUEST_PREFIX, ""));
    }
    private String replaceAPlaceholderInARandomPattern
            (String[] patterns, String placeholder, String replacement) {
        int randomIndex = rand.nextInt(patterns.length);
        return patterns[randomIndex].replaceAll(placeholder, replacement);
    }

	private String replyToIllegalRequest(String statement) {

		return replaceAPlaceholderInARandomPattern
                (illegalRequestsReplies, ILLIGAL_REQUEST_PATTERN, statement);
	}
    private static void copy_str_array(String[] src, String[] dest) {
        for(int i = 0 ; i < src.length ; i = i+1) {
            dest[i] = src[i];
        }
    }
}
