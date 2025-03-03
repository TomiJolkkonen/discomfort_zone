import { test, expect } from '@playwright/test';

test('frontpage has correct title', async ({ page }) => {
  await page.goto('http://localhost:3000');
  await expect(page).toHaveTitle(/Notes/);
});