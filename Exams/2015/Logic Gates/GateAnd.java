public class GateAnd extends LogicGate {
    public GateAnd(LogicVariable w1, LogicVariable x1, LogicVariable x2) {
        super(w1, x1, x2);

        update();
    }

    @Override
    public Object[] getInputs() {
        return new LogicVariable[]{x1, x2};
    }

    @Override
    public String getSymbol() {
        return "AND";
    }

    @Override
    public String getFormula() {
        return getSymbol() + "(" + x1.getFormula() + "," + x2.getFormula() + ")";
    }

    @Override
    public void update() {
        w1.setValue(x1.getValue() && x2.getValue());
        w1.setCalculatedBy(this);
    }
}
