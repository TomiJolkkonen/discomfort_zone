# DAX Cheat Sheet

## 1. **Basic Syntax**

### Measures vs. Calculated Columns

- **Measure**: A formula that computes a value based on the data in your model. Measures are recalculated whenever they are referenced in the report context (e.g., slicers, filters).
- **Calculated Column**: A new column that is calculated row-by-row in the data model.

---

## 2. **Basic DAX Functions**

### SUM
```dax
SUM(Column)


Total Sales = SUM(Sales[SalesAmount])


AVERAGE(Column)


Average Sales = AVERAGE(Sales[SalesAmount])


COUNT(Column)


Count of Sales = COUNT(Sales[SalesAmount])


COUNTA(Column)


Count of Non-Empty Sales = COUNTA(Sales[SalesAmount])


COUNTROWS(Table)


Total Rows = COUNTROWS(Sales)


DISTINCTCOUNT(Column)


Distinct Products = DISTINCTCOUNT(Sales[ProductID])


MAX(Column)
MIN(Column)


Max Sales = MAX(Sales[SalesAmount])
Min Sales = MIN(Sales[SalesAmount])


IF(Condition, TrueResult, FalseResult)


Sales Category = IF(Sales[SalesAmount] > 1000, "High", "Low")


TODAY()


Today = TODAY()


NOW()


Current Date and Time = NOW()


DATE(Year, Month, Day)


Custom Date = DATE(2022, 12, 25)


DATEDIFF(StartDate, EndDate, Interval)


Days Difference = DATEDIFF(Sales[StartDate], Sales[EndDate], DAY)


YEAR(Date)
MONTH(Date)
DAY(Date)


Year of Sale = YEAR(Sales[SaleDate])
Month of Sale = MONTH(Sales[SaleDate])


WEEKNUM(Date, [ReturnType])


Week Number = WEEKNUM(Sales[SaleDate])


EOMONTH(Date, Months)


End of Month = EOMONTH(Sales[SaleDate], 0)


CALCULATE(Expression, Filter1, Filter2, ...)


Total Sales (High Sales Only) = CALCULATE(SUM(Sales[SalesAmount]), Sales[SalesAmount] > 1000)


FILTER(Table, Expression)


Filtered Sales = FILTER(Sales, Sales[SalesAmount] > 1000)


ALL(Table or Column)


Total Sales (All Data) = CALCULATE(SUM(Sales[SalesAmount]), ALL(Sales))


ALLEXCEPT(Table, Column1, Column2, ...)


Sales by Product (No Filter) = CALCULATE(SUM(Sales[SalesAmount]), ALLEXCEPT(Sales, Sales[ProductID]))


VALUES(Column)


Distinct Products Sold = VALUES(Sales[ProductID])


EARLIER(Column, [N])


Rank = RANKX(ALL(Sales), Sales[SalesAmount], , DESC, Skip)


HASONEVALUE(Column)


Single Product = IF(HASONEVALUE(Sales[ProductID]), "Yes", "No")


SELECTEDVALUE(Column, [AlternateResult])


Selected Product = SELECTEDVALUE(Sales[ProductID], "No Product Selected")


SUMX(Table, Expression)


Total Sales = SUMX(Sales, Sales[SalesAmount] * Sales[Quantity])


AVERAGEX(Table, Expression)


Average Sales = AVERAGEX(Sales, Sales[SalesAmount])


MINX(Table, Expression)
MAXX(Table, Expression)


Min Sales = MINX(Sales, Sales[SalesAmount])
Max Sales = MAXX(Sales, Sales[SalesAmount])


CONCATENATE(Text1, Text2)


Full Name = CONCATENATE(Employees[FirstName], Employees[LastName])


LEN(Text)


Name Length = LEN(Employees[FirstName])


UPPER(Text)
LOWER(Text)


Upper Name = UPPER(Employees[FirstName])
Lower Name = LOWER(Employees[FirstName])


IFERROR(Expression, ValueIfError)


Safe Division = IFERROR(Sales[Amount] / Sales[Quantity], 0)


RANKX(Table, Expression, [Value], [Order], [Ties])


Rank by Sales = RANKX(ALL(Sales), Sales[SalesAmount], , DESC, Skip)


USERELATIONSHIP(Column1, Column2)


Sales by Inactive Date = CALCULATE(SUM(Sales[SalesAmount]), USERELATIONSHIP(Sales[OrderDate], Calendar[Date]))


