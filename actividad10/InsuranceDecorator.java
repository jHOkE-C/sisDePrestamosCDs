// Decorator concreto: añade coste fijo de seguro
public class InsuranceDecorator extends LoanDecorator {
    private static final double INSURANCE_FEE = 2.0;
    public InsuranceDecorator(ILoan loan) {
        super(loan);
    }
    @Override
    public double calculateCost() {
        return super.calculateCost() + INSURANCE_FEE;
    }
}