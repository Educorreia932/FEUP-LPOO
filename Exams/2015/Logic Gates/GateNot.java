public class GateNot extends LogicGate {
    public GateNot(LogicVariable w1, LogicVariable x1) {
        super(w1, x1);

        update();
    }

    @Override
    public Object[] getInputs() {
        return new LogicVariable[]{x1};
    }

    @Override
    public String getSymbol() {
        return "NOT";
    }

    @Override
    public String getFormula() {
        return getSymbol() + "(" + x1.getFormula() + ")";
    }

    @Override
    public void update() {
        this.w1.setCalculatedBy(this);
        this.w1.setValue(!this.x1.getValue());
    }
}
