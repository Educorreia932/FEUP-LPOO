public abstract class LogicGate {
    protected LogicVariable w1, x1, x2;

    public LogicGate(LogicVariable w1, LogicVariable x1) {
        this.w1 = w1;
        this.x1 = x1;
    }

    public LogicGate(LogicVariable w1, LogicVariable x1, LogicVariable x2) {
        this.w1 = w1;
        this.x1 = x1;
        this.x2 = x2;
    }

    public LogicVariable getOutput() {
        return w1;
    }

    public abstract Object[] getInputs();

    public abstract String getSymbol();

    public abstract String getFormula();

    public abstract void update();
}
