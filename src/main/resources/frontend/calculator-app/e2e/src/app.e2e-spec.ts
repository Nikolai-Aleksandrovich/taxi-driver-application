import { browser, logging } from 'protractor';
import { MaterialDashboardAngularPage } from './app.po';

describe('material-dashboard-angular App', () => {
  let page: MaterialDashboardAngularPage;

  beforeEach(() => {
    page = MaterialDashboardAngularPage();
  });

  it('should display message saying app works', async () => {
    await page.navigateTo();
    expect(await page.getTitleText()).toEqual('calculator-app app is running!');
  });

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
});
