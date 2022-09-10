import { Component, OnInit } from '@angular/core';
import { SiteInfo } from 'src/app/shared/models/SiteInfo';
import { SitesService } from '../../services/sites.service';
import { UploaderService } from '../../services/uploader.service';

@Component({
  selector: 'app-sites',
  templateUrl: './sites-page.component.html',
  styleUrls: ['./sites-page.component.css']
})
export class SitesPageComponent implements OnInit {

  constructor(
    private sitesService: SitesService,
    private UploaderService: UploaderService,
  ) { }

  public sites: SiteInfo[] = [];

  public page = 0;
  public size = 10;

  public totalRecords = 0;

  ngOnInit(): void {
    this.renderListSites({ page: this.page, rows: this.size });
  }

  deleteSite(siteName: string) {
    this.UploaderService.deleteFile(siteName).subscribe(() => {
      this.renderListSites({ page: this.page, rows: this.size });
    })
  }

  renderListSites(pageable: any) {
    this.page = pageable.page;
    this.size = pageable.rows;

    this.sitesService.getAllSitesInfo(this.page, this.size).subscribe(res => {
      this.sites = res.content;
      this.totalRecords = res.totalElements;
    });
  }

}
