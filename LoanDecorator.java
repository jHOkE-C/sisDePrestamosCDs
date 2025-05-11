// Patrón Decorator: base para añadir responsabilidades
public abstract class LoanDecorator implements ILoan {
    protected ILoan wrappedLoan;
    public LoanDecorator(ILoan loan) { this.wrappedLoan = loan; }
    @Override
    public double calculateCost() {
        return wrappedLoan.calculateCost();
    }
}