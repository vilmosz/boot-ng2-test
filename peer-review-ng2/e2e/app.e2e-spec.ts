import { PeerReviewNg2Page } from './app.po';

describe('peer-review-ng2 App', function() {
  let page: PeerReviewNg2Page;

  beforeEach(() => {
    page = new PeerReviewNg2Page();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
