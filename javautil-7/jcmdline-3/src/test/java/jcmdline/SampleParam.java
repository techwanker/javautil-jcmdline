package jcmdline;

/**
 * A Parameter class that accepts string parameters of a specified length.
 */
public class SampleParam extends AbstractParameter {
    private int length;
    public SampleParam(String tag, String desc, int length) {
        setTag(tag);
        setDesc(desc);
        this.length = length;
        setOptionLabel("<s>");
    }
    public void validateValue(String val) throws CmdLineException {
        super.validateValue(val);
        if (val.length() != length) {
            throw new CmdLineException(getTag() + " must be a string of " + 
                                       length + " characters in length");
        }

    }
}
