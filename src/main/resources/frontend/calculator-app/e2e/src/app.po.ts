import { browser, by, element } from 'protractor';

export class MaterialDashboardAngularPage {
  async navigateTo(): Promise<unknown> {
    return browser.get('/api');
  }

  async getTitleText(): Promise<string> {
    return element(by.css('app-root .content span')).getText();
  }
  getParagraphText() {
      return element(by.css('app-root h1')).getText();
    }
}
