## Sample Data

This file contains a small sample of the data necessary to build the test data set.  This data is not normalised and will need normalisation to fit the data model. You will also need to generate significantly more data for demonstrating your application.

### Security Data

| isin | cusip | issuer_name | maturity_date | type | coupon | face_value | status | currency |
|------|-------|-------------|---------------|------|--------|------------|--------|----------|
| A12356111 | 123456780 | Bundesbank | 2024/08/23 | Municipal | 2.0 | 900 | active | USD |
| A12356112 | 123456780 | Bundesbank | 2024/08/27 | Sovereign | 2.0 | 900 | active | USD |
| GBP1235647 | 4443456780 | Tesco | 2024/08/21 | Corporate | 1.0 | 1500 | active | GBP |

### Trade Data

| book | security | counterparty | currency | status | quantity | unit_price | buy_sell | trade_date | settlement_date |
|------|----------|--------------|----------|--------|----------|------------|----------|------------|-----------------|
| BA1 | A12356111 | UBS | USD | open | 50 | 90 | buy | 2024/05/13 | 2025/08/23 |
| CX9 | GBP1235647 | HSBC | GBP | open | 70 | 45 | sell | 2024/05/13 | 2025/08/23 |
| CX9 | GBP1235647 | HSBC | GBP | cancelled | 60 | 40 | sell | 2024/05/12 | 2025/08/22 |
