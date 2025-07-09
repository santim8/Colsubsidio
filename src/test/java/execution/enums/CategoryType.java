package execution.enums;

/**
 * Enum CategoryType represents various categories of tests.
 * These categories are generally used for grouping and filtering test cases
 * based on their purpose or behavior during execution.
 *
 * The categories include:
 * - SMOKE: Represents critical tests that verify basic functionality.
 * - REGRESSION: Represents tests that verify the correctness of existing functionality after changes.
 * - SANITY: Represents a focused subset of tests for validating specific functionality.
 */
public enum CategoryType {
    SMOKE,
    REGRESSION,
    SANITY;
}
