public class GateOr extends LogicGate {
    public GateOr(LogicVariable w1, LogicVariable x1, LogicVariable x2) throws ColisionException {
        super(w1, x1, x2);

        if (w1.getCalculatedBy() != null)
            throw new ColisionException();

        update();
    }

    @Override
    public Object[] getInputs() {
        return new LogicVariable[]{x1, x2};
    }

    @Override
    public String getSymbol() {
        return "OR";
    }

    @Override
    public String getFormula() {
        return getSymbol() + "(" + x1.getFormula() + "," + x2.getFormula() + ")";
    }

    @Override
    public void update() {
        this.w1.setValue(this.x1.getValue() || this.x2.getValue());
        this.w1.setCalculatedBy(this);
    }
}
