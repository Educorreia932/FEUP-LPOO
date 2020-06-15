public class LogicVariable {
    private String name;
    private boolean value;
    private LogicGate gate;

    public LogicVariable(String x1, boolean b) {
        name = x1;
        value = b;
    }

    public LogicVariable(String y1) {
        name = y1;
        value = false;
    }

    public String getName() {
        return name;
    }

    public boolean getValue() {
        if (getCalculatedBy() != null)
            getCalculatedBy().update();

        return value;
    }

    public LogicGate getCalculatedBy() {
        return gate;
    }

    public String getFormula() {
        if (getCalculatedBy() == null)
            return name;

        else
            return getCalculatedBy().getFormula();
    }

    public void setValue(boolean b) {
        value = b;
    }

    public void setCalculatedBy(LogicGate gate) {
        this.gate = gate;
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(((LogicVariable) obj).getName());
    }
}
